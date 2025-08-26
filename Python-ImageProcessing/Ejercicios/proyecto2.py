import streamlit as st
import numpy as np
import matplotlib.pyplot as plt
from PIL import Image
from scipy.ndimage import label
import cv2

# ---------------------
# FUNCIONES AUXILIARES
# ---------------------
def rgb2gray(img):
    img = np.asarray(img)
    return np.dot(img[...,:3], [0.299, 0.587, 0.114])

def binarizar(imagen, umbral):
    return np.where(imagen > umbral, 1.0, 0.0)

def cierre(imagen, kernel):
    return erosion(dilatacion(imagen, kernel), kernel)

def erosion(imagen, kernel):
    img_h, img_w = imagen.shape
    k_h, k_w = kernel.shape
    pad_h = k_h // 2
    pad_w = k_w // 2
    resultado = np.zeros_like(imagen)
    imagen_padded = np.pad(imagen, ((pad_h, pad_h), (pad_w, pad_w)), mode='constant', constant_values=0)
    for i in range(img_h):
        for j in range(img_w):
            region = imagen_padded[i:i + k_h, j:j + k_w]
            if np.array_equal(region * kernel, kernel):
                resultado[i, j] = 1.0
    return resultado

def dilatacion(imagen, kernel):
    img_h, img_w = imagen.shape
    k_h, k_w = kernel.shape
    pad_h = k_h // 2
    pad_w = k_w // 2
    resultado = np.zeros_like(imagen)
    imagen_padded = np.pad(imagen, ((pad_h, pad_h), (pad_w, pad_w)), mode='constant', constant_values=0)
    for i in range(img_h):
        for j in range(img_w):
            region = imagen_padded[i:i + k_h, j:j + k_w]
            if np.any(region * kernel):
                resultado[i, j] = 1.0
    return resultado

# ---------------------
# INTERFAZ STREAMLIT
# ---------------------
st.title("💊 Detección de Pastillas Faltantes")

st.write("""
Sube una imagen de un paquete de pastillas (blíster) y detectaremos si faltan pastillas.
""")

uploaded_file = st.file_uploader("Sube una imagen del blíster", type=["png", "jpg", "jpeg"])

if uploaded_file is not None:
    image = Image.open(uploaded_file)
    st.image(image, caption='Imagen Original', use_container_width=True)

    # Escala de grises
    img_gray = rgb2gray(image)

    # Binarización
    umbral = st.slider("Umbral para binarización", 0, 255, 100)
    img_bin = binarizar(img_gray, umbral)
    st.image(img_bin, caption='Imagen binarizada', use_container_width=True)

    # Cierre morfológico
    kernel = np.ones((5, 5))
    img_cerrada = cierre(img_bin, kernel)
    st.image(img_cerrada, caption='Imagen después del cierre morfológico', use_container_width=True)

    img_invertida = 1.0 - img_cerrada

    # Etiquetamos las regiones negras (invertidas ahora son blancas)
    labeled, num_huecos = label(img_invertida)

    # Filtro: eliminamos regiones pequeñas
    areas = []
    for region_id in range(1, labeled.max() + 1):
        area = np.sum(labeled == region_id)
        if area > 6000:
            areas.append(area)

    st.write(f"🕳️ Huecos grandes detectados: **{len(areas)}**")

    if len(areas) > 0:
        st.error("⚠️ Se detectaron pastillas faltantes.")
    else:
        st.success("✅ No se detectaron pastillas faltantes.")

    # Visualización
    fig, ax = plt.subplots()
    ax.imshow(labeled, cmap='nipy_spectral')
    ax.set_title("Mapa de huecos detectados")
    st.pyplot(fig)
