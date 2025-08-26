import numpy as np
import espaciosColor as ec  
import matplotlib.image as mpimg
import matplotlib.pyplot as plt

# Cargar y convertir a escala de grises
img = mpimg.imread('cat.jpeg')
imagen_gray = ec.rgb2gray(img)

# Erosión (mínimo local)
def erosion_grises(imagen, kernel):
    img_h, img_w = imagen.shape
    k_h, k_w = kernel.shape
    pad_h, pad_w = k_h // 2, k_w // 2
    imagen_padded = np.pad(imagen, ((pad_h, pad_h), (pad_w, pad_w)), mode='edge')
    resultado = np.zeros_like(imagen)

    for i in range(img_h):
        for j in range(img_w):
            region = imagen_padded[i:i + k_h, j:j + k_w]
            resultado[i, j] = np.min(region[kernel == 1])
    return resultado

# Dilatación (máximo local)
def dilatacion_grises(imagen, kernel):
    img_h, img_w = imagen.shape
    k_h, k_w = kernel.shape
    pad_h, pad_w = k_h // 2, k_w // 2
    imagen_padded = np.pad(imagen, ((pad_h, pad_h), (pad_w, pad_w)), mode='edge')
    resultado = np.zeros_like(imagen)

    for i in range(img_h):
        for j in range(img_w):
            region = imagen_padded[i:i + k_h, j:j + k_w]
            resultado[i, j] = np.max(region[kernel == 1])
    return resultado

# Apertura: erosión seguida de dilatación
def apertura_grises(imagen, kernel):
    return dilatacion_grises(erosion_grises(imagen, kernel), kernel)

# Cierre: dilatación seguida de erosión
def cierre_grises(imagen, kernel):
    return erosion_grises(dilatacion_grises(imagen, kernel), kernel)

# Top-Hat: original - apertura
def tophat_grises(imagen, kernel):
    return imagen - apertura_grises(imagen, kernel)

# Black-Hat: cierre - original
def blackhat_grises(imagen, kernel):
    return cierre_grises(imagen, kernel) - imagen



# Crear kernel
kernel = np.ones((5, 5))
# kernel = np.array([[1, 1, 1],
#                    [0, 1, 0],
#                    [0, 1, 0]])


# Aplicar operaciones
imagenErosionada = erosion_grises(imagen_gray, kernel)
imagenDilatada = dilatacion_grises(imagen_gray, kernel)
imagenApertura = apertura_grises(imagen_gray, kernel)
ImagenCerrada = cierre_grises(imagen_gray, kernel)
tophat = tophat_grises(imagen_gray, kernel)
blackhat = blackhat_grises(imagen_gray, kernel)

# Mostrar resultados
fig, axes = plt.subplots(2, 4, figsize=(16, 8))
axes = axes.ravel()
titles = ['Original', 'Escala de Grises', 'Erosión', 'Dilatación', 'Apertura', 'Cierre', 'Top-Hat', 'Black-Hat']
imagenes = [img, imagen_gray, imagenErosionada, imagenDilatada, imagenApertura, ImagenCerrada, tophat, blackhat]

for i in range(8):
    axes[i].imshow(imagenes[i], cmap='gray')
    axes[i].set_title(titles[i])
    axes[i].axis('off')

plt.tight_layout()
plt.show()




img2 = mpimg.imread('sample2.jpg')
imagen_gray2 = ec.rgb2gray(img2)

# Crear kernel
kernel2 = np.array([[1, 1, 1],
                    [0, 1, 0],
                    [0, 1, 0]])


# Aplicar operaciones
imagenErosionada2 = erosion_grises(imagen_gray2, kernel2)
imagenDilatada2 = dilatacion_grises(imagen_gray2, kernel2)
imagenApertura2 = apertura_grises(imagen_gray2, kernel2)
ImagenCerrada2 = cierre_grises(imagen_gray2, kernel2)
tophat2 = tophat_grises(imagen_gray2, kernel2)
blackhat2 = blackhat_grises(imagen_gray2, kernel2)

# Mostrar resultados
fig, axes = plt.subplots(2, 4, figsize=(16, 8))
axes = axes.ravel()
titles = ['Original', 'Escala de Grises', 'Erosión', 'Dilatación', 'Apertura', 'Cierre', 'Top-Hat', 'Black-Hat']
imagenes2 = [img2, imagen_gray2, imagenErosionada2, imagenDilatada2, imagenApertura2, ImagenCerrada2, tophat2, blackhat2]

for i in range(8):
    axes[i].imshow(imagenes2[i], cmap='gray')
    axes[i].set_title(titles[i])
    axes[i].axis('off')

plt.tight_layout()
plt.show()






img3 = mpimg.imread('sample2.jpg')
imagen_gray3 = ec.rgb2gray(img3)

# Crear kernel
kernel3 = np.ones((5, 5))
# kernel = np.array([[1, 1, 1],
#                    [0, 1, 0],
#                    [0, 1, 0]])


# Aplicar operaciones
imagenErosionada3 = erosion_grises(imagen_gray3, kernel3)
imagenDilatada3 = dilatacion_grises(imagen_gray3, kernel3)
imagenApertura3 = apertura_grises(imagen_gray3, kernel3)
ImagenCerrada3 = cierre_grises(imagen_gray3, kernel3)
tophat3 = tophat_grises(imagen_gray3, kernel3)
blackhat3 = blackhat_grises(imagen_gray3, kernel3)

# Mostrar resultados
fig, axes = plt.subplots(2, 4, figsize=(16, 8))
axes = axes.ravel()
titles = ['Original', 'Escala de Grises', 'Erosión', 'Dilatación', 'Apertura', 'Cierre', 'Top-Hat', 'Black-Hat']
imagenes3 = [img3, imagen_gray3, imagenErosionada3, imagenDilatada3, imagenApertura3, ImagenCerrada3, tophat3, blackhat3]

for i in range(8):
    axes[i].imshow(imagenes3[i], cmap='gray')
    axes[i].set_title(titles[i])
    axes[i].axis('off')

plt.tight_layout()
plt.show()