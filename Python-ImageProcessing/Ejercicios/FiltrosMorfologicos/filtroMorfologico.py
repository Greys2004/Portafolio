import numpy as np
import espaciosColor as ec  
import matplotlib.image as mpimg
import matplotlib.pyplot as plt

img = mpimg.imread('cat.jpeg')
imagen_gray = ec.rgb2gray(img) 

def binarizar(imagen, umbral):
    imagen_binaria = np.where(imagen > umbral, 1.0, 0.0)
    return imagen_binaria



# Erosión
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
            else:
                resultado[i, j] = 0.0
    return resultado

# Dilatación
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
            else:
                resultado[i, j] = 0.0
    return resultado

# Apertura
def apertura(imagen, kernel):
    return dilatacion(erosion(imagen, kernel), kernel)

# Cierre
def cierre(imagen, kernel):
    return erosion(dilatacion(imagen, kernel), kernel)




imagen_binarizada = binarizar(imagen_gray, umbral=85)
kernel = np.ones((5, 5))

# Aplicar operaciones
imagen_erosionada = erosion(imagen_binarizada, kernel)
imagen_dilatada = dilatacion(imagen_binarizada, kernel)
imagen_apertura = apertura(imagen_binarizada, kernel)
imagen_cierre = cierre(imagen_binarizada, kernel)

# Mostrar todas las imágenes
plt.figure(figsize=(20, 5))

plt.subplot(1, 6, 1)
plt.imshow(imagen_gray, cmap='gray')
plt.title('Original')
plt.axis('off')

plt.subplot(1, 6, 2)
plt.imshow(imagen_binarizada, cmap='gray')
plt.title('Binarizada')
plt.axis('off')

plt.subplot(1, 6, 3)
plt.imshow(imagen_erosionada, cmap='gray')
plt.title('Erosión')
plt.axis('off')

plt.subplot(1, 6, 4)
plt.imshow(imagen_dilatada, cmap='gray')
plt.title('Dilatación')
plt.axis('off')

plt.subplot(1, 6, 5)
plt.imshow(imagen_apertura, cmap='gray')
plt.title('Apertura')
plt.axis('off')

plt.subplot(1, 6, 6)
plt.imshow(imagen_cierre, cmap='gray')
plt.title('Cierre')
plt.axis('off')

plt.tight_layout()
plt.show()




# imagen_binarizada2 = binarizar(imagen_gray, umbral=100)
# kernel2 = np.ones((3, 3))

# # Aplicar operaciones
# imagen_apertura2 = apertura(imagen_binarizada2, kernel2)
# imagen_erosionada2 = erosion(imagen_apertura2, kernel2)

# # Mostrar todas las imágenes
# plt.figure(figsize=(10, 5))

# plt.subplot(1, 1, 1)
# plt.imshow(imagen_erosionada2, cmap='gray')
# plt.title('Borrado de puntos')
# plt.axis('off')

# plt.tight_layout()
# plt.show()

imagen_binarizada3 = binarizar(imagen_gray, umbral=100)
kernel3 = np.ones((5, 5))

# Aplicar operaciones
imagen_erosionada3 = erosion(imagen_binarizada3, kernel3)
imagen_apertura3 = apertura(imagen_erosionada3, kernel3)

# Mostrar todas las imágenes
plt.figure(figsize=(10, 5))

plt.subplot(1, 1, 1)
plt.imshow(imagen_apertura3, cmap='gray')
plt.title('Borrado de puntos')
plt.axis('off')

plt.tight_layout()
plt.show()

imagen_binarizada3 = binarizar(imagen_gray, umbral=100)
kernel3 = np.ones((3, 3))

# Aplicar operaciones
imagen_erosionada3 = erosion(imagen_binarizada3, kernel3)
imagen_apertura3 = apertura(imagen_erosionada3, kernel3)
imagen_erosionada33 = erosion(imagen_apertura3, kernel3)

# Mostrar todas las imágenes
plt.figure(figsize=(10, 5))

plt.subplot(1, 1, 1)
plt.imshow(imagen_erosionada33, cmap='gray')
plt.title('Borrado de puntos')
plt.axis('off')

plt.tight_layout()
plt.show()