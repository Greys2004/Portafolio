import numpy as np
from scipy.ndimage import convolve
from scipy.signal import correlate2d, convolve2d
import espaciosColor as ec  
import matplotlib.image as mpimg
import matplotlib.pyplot as plt

img = mpimg.imread('sample2.jpg')
imagen_gray = ec.rgb2gray(img) 

# ======================
# KERNELS SOBEL Y PREWITT
# ======================
# Kernels de Sobel
sobel_x = np.array([[-1, 0, 1],
                    [-2, 0, 2],
                    [-1, 0, 1]])

sobel_y = np.array([[-1, -2, -1],
                    [ 0,  0,  0],
                    [ 1,  2,  1]])

# Aplicar convolución
Gx = convolve(imagen_gray, sobel_x)
Gy = convolve(imagen_gray, sobel_y)

# Magnitud del gradiente
Gxy = np.sqrt(Gx**2 + Gy**2)

# Ángulo del gradiente
theta = np.arctan2(Gy, Gx) * 180 / np.pi
theta_bin = np.where(theta > 0, 1.0, 0.0)  # binarización opcional para visualización

# Mostrar resultados
plt.figure(figsize=(16, 4))

plt.subplot(1, 5, 1)
plt.title("Imagen")
plt.imshow(imagen_gray, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 2)
plt.title("Gx")
plt.imshow(Gx, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 3)
plt.title("Gy")
plt.imshow(Gy, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 4)
plt.title("|Gxy|")
plt.imshow(Gxy, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 5)
plt.title("theta")
plt.imshow(theta_bin, cmap='gray')
plt.axis('off')

plt.tight_layout()
plt.show()


# Prewitt
prewitt_x = np.array([[1, 0, -1],
                      [1, 0, -1],
                      [1, 0, -1]])

prewitt_y = np.array([[1, 1, 1],
                      [ 0,  0,  0],
                      [ -1,  -1,  -1]])

# Aplicar convolución
Gx2 = convolve(imagen_gray, prewitt_x)
Gy2 = convolve(imagen_gray, prewitt_y)

# Magnitud del gradiente
Gxy2 = np.sqrt(Gx2**2 + Gy2**2)

# Ángulo del gradiente
theta2 = np.arctan2(Gy2, Gx2) * 180 / np.pi
theta_bin2 = np.where(theta2 > 0, 1.0, 0.0)  # binarización opcional para visualización

# Mostrar resultados
plt.figure(figsize=(16, 4))

plt.subplot(1, 5, 1)
plt.title("Imagen")
plt.imshow(imagen_gray, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 2)
plt.title("Gx")
plt.imshow(Gx2, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 3)
plt.title("Gy")
plt.imshow(Gy2, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 4)
plt.title("|Gxy|")
plt.imshow(Gxy2, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 5)
plt.title("theta")
plt.imshow(theta_bin2,cmap='gray')
plt.axis('off')

plt.tight_layout()
plt.show()














# ======================
# KERNELS SOBEL Y PREWITT
# ======================
# Kernels de Sobel
sobel_x = np.array([[-1, 0, 1],
                    [-2, 0, 2],
                    [-1, 0, 1]])

sobel_y = np.array([[-1, -2, -1],
                    [ 0,  0,  0],
                    [ 1,  2,  1]])

def correlacion2D_manual(f, h):
    if len(h) % 2 == 0:
        print("El kernel debe tener dimensiones impares.")
    else:
        # Tamaños
        m, n = f.shape
        kh, kw = h.shape

        # Padding
        pad_h = kh // 2
        pad_w = kw // 2

        # Rellenar la imagen con ceros alrededor
        f_padded = np.pad(f, ((pad_h, pad_h), (pad_w, pad_w)), mode='constant', constant_values=0)

        # Salida del mismo tamaño que f
        output = np.zeros_like(f)

        # Aplicar correlación
        for i in range(m):
            for j in range(n):
                region = f_padded[i:i+kh, j:j+kw]
                output[i, j] = np.sum(region * h)

        return output

def convulsion2D_manual(f, h):
    if len(h) % 2 == 0:
        print("El kernel debe tener dimensiones impares.")
    else:
        # Voltear kernel (horizontal y verticalmente)
        h_flipped = np.flip(h)
        # Usar correlación con kernel volteado
        return correlacion2D_manual(f, h_flipped)

# Aplicar convolución
Gx3 = convulsion2D_manual(imagen_gray, sobel_x)
Gy3 = convulsion2D_manual(imagen_gray, sobel_y)


# Magnitud del gradiente
Gxy3 = np.sqrt(Gx3**2 + Gy3**2)

# Ángulo del gradiente
theta3 = np.arctan2(Gy3, Gx3) * 180 / np.pi
theta_bin3 = np.where(theta3 > 0, 1.0, 0.0)  # binarización opcional para visualización

# Mostrar resultados
plt.figure(figsize=(16, 4))

plt.subplot(1, 5, 1)
plt.title("Imagen")
plt.imshow(imagen_gray, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 2)
plt.title("Gx")
plt.imshow(Gx3, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 3)
plt.title("Gy")
plt.imshow(Gy3, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 4)
plt.title("|Gxy|")
plt.imshow(Gxy3, cmap='gray')
plt.axis('off')

plt.subplot(1, 5, 5)
plt.title("theta")
plt.imshow(theta_bin3, cmap='gray')
plt.axis('off')

plt.tight_layout()
plt.show()