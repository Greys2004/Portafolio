import numpy as np

def filtro_mediana(imagen, tamaño_kernel):
    # Copia de la imagen para no modificar la original
    salida = np.copy(imagen)
    
    # Radio del kernel
    k = tamaño_kernel // 2
    
    # Dimensiones de la imagen
    alto, ancho = imagen.shape
    
    # Recorremos cada píxel, sin tocar los bordes
    for i in range(k, alto - k):
        for j in range(k, ancho - k):
            # Extraemos la ventana (submatriz del tamaño del kernel)
            ventana = []
            for a in range(-k, k+1):
                for b in range(-k, k+1):
                    ventana.append(imagen[i + a, j + b])
            
            # Ordenamos manualmente la ventana
            for x in range(len(ventana)):
                for y in range(x + 1, len(ventana)):
                    if ventana[y] < ventana[x]:
                        ventana[x], ventana[y] = ventana[y], ventana[x]
            
            # Tomamos el valor del centro (mediana)
            mediana = ventana[len(ventana) // 2]
            
            # Reemplazamos el valor del píxel central
            salida[i, j] = mediana
    
    return salida


# Creamos una imagen de prueba
imagen = np.array([
    [10, 20, 30, 40, 50],
    [15, 25, 35, 45, 55],
    [20, 30, 255, 60, 70],
    [25, 35, 45, 65, 75],
    [30, 40, 50, 70, 80]
])

# Aplicamos el filtro de mediana con kernel 3x3
resultado = filtro_mediana(imagen, 3)

# Mostramos el resultado
print("Imagen original:")
print(imagen)

print("\nImagen filtrada:")
print(resultado)












import numpy as np
import matplotlib.image as mpimg
import matplotlib.pyplot as plt
import espaciosColor as ec  
import miLibreria as ml

# Cargar imagen
imagen = mpimg.imread('sample2.jpg')
imagen_gray = ec.rgb2gray(imagen) 
sal = ml.ruidoSalPimienta(imagen_gray, pp = 0.1, ps= 0.1)


# Aplica el filtro que hicimos antes
imagen_filtrada = filtro_mediana(sal, tamaño_kernel=3)

# Mostrar imagen original y filtrada
plt.figure(figsize=(10, 4))

plt.subplot(1, 2, 1)
plt.title("Imagen original con ruido")
plt.imshow(sal, cmap='gray')
plt.axis('off')

plt.subplot(1, 2, 2)
plt.title("Imagen filtrada con mediana")
plt.imshow(imagen_filtrada, cmap='gray')
plt.axis('off')

plt.tight_layout()
plt.show()


