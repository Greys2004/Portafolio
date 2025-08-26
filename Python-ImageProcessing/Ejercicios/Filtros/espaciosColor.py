import numpy as np

# 0.299 R + 0.587 G + 0.114 B
def rgb2gray(img):
    #Obteniendo dimensiones de mi imagen
    alto, ancho, canales = img.shape
    
    #Creando una imagen en escala de grises con puros 0
    gray = np.zeros((alto, ancho), dtype= float)
    
    
    #Recorrer la imagenoriginal pixel a pixel
    for i in range(alto):
        for j in range(ancho):
            
            #Obtener los valores de R, G y B de cada pixel
            R = img[i,j,0]
            G = img[i,j,1]
            B = img[i,j,2]
            
            #Convertir a escala de grises
            Y = 0.299*R + 0.587*G + 0.114*B
            
            #Asignar el valor a la imagen en escala de grises
            gray[i,j] = Y
            
    return gray

import numpy as np

def rgb2cmyk(img):
    alto, ancho, canales = img.shape
    
    cmyk = np.zeros((alto, ancho, 4), dtype=float)  # Crear una matriz con 4 canales para CMYK
    
    for i in range(alto):
        for j in range(ancho):
            R = img[i, j, 0]
            G = img[i, j, 1]
            B = img[i, j, 2]
            
            # Normalizar valores
            RR = R / 255
            GG = G / 255
            BB = B / 255
            
            # Calcular negro
            K = 1 - max(RR, GG, BB)
            
            # Calcular Cian
            C = (1 - RR - K) / (1 - K) if (1 - K) != 0 else 0
            
            # Calcular Magenta
            M = (1 - GG - K) / (1 - K) if (1 - K) != 0 else 0
            
            # Calcular amarillo
            Y = (1 - BB - K) / (1 - K) if (1 - K) != 0 else 0
            
            # Asignar valores a la matriz
            cmyk[i, j] = [C, M, Y, K] 
    
    return cmyk


def rgb2hsv(img):
    alto, ancho, canales = img.shape
    
    hsv = np.zeros((alto, ancho, 3), dtype=float) 
    
    for i in range(alto):
        for j in range(ancho):
            
            R = img[i, j, 0]
            G = img[i, j, 1]
            B = img[i, j, 2]
            
            # Normalizar valores
            RR = R / 255
            GG = G / 255
            BB = B / 255
            
            # Calcular el máximo y el mínimo
            max_val = max(RR, GG, BB)
            min_val = min(RR, GG, BB)
            diferencia = max_val - min_val
            
            # Calcular Tono (H)
            if diferencia == 0:
                H = 0
            elif max_val == RR:
                H = (60 * ((GG - BB) / diferencia) + 360) % 360  # Asegurar que esté en [0,360]
            elif max_val == GG:
                H = (60 * ((BB - RR) / diferencia) + 120) % 360
            elif max_val == BB:
                H = (60 * ((RR - GG) / diferencia) + 240) % 360
            
            # Calcular Saturación (S)
            S = 0 if max_val == 0 else (diferencia / max_val) * 100
            
            # Calcular Valor (V)
            V = max_val * 100  
            
            # Guardar valores en la matriz
            hsv[i, j] = [H, S, V]  
    
    return hsv

def rgb2lab(img):
    alto, ancho, canales = img.shape
    
    lab = np.zeros((alto, ancho, 3), dtype=float) 
    
    for i in range(alto):
        for j in range(ancho):
            
            R = img[i, j, 0]
            G = img[i, j, 1]
            B = img[i, j, 2]
            
            # Normalizar valores
            RR = R / 255
            GG = G / 255
            BB = B / 255
            # Convertir RGB A RGB Lineal
            
            if RR > 0.04045:
                Rlineal = ((RR + 0.055) / 1.055) ** 2.4
            else:
                Rlineal = RR / 12.92
                
            if GG > 0.04045:
                Glineal = ((GG + 0.055) / 1.055) ** 2.4
            else:
                Glineal = GG / 12.92
                
            if BB > 0.04045:
                Blineal = ((BB + 0.055) / 1.055) ** 2.4
            else:
                Blineal = BB / 12.92
            
            # Convertir RGB lineal a XYZ
            X = Rlineal * 0.4124564 + Glineal * 0.3575761 + Blineal * 0.1804375
            Y = Rlineal * 0.2126729 + Glineal * 0.7151522 + Blineal * 0.0721750
            Z = Rlineal * 0.0193339 + Glineal * 0.1191920 + Blineal * 0.9503041
            
            # Normalizar XYZ
            X = X / 0.950456
            Y = Y / 1.000000
            Z = Z / 1.088754
            
            # Convertir XYZ a Lab
            # Aplicar la transformación f(t)
            def f(t):
                return t ** (1/3) if t > 0.008856 else (7.787 * t) + (16 / 116)

            X, Y, Z = f(X), f(Y), f(Z)

            # Calcular valores LAB
            L = (116 * Y) - 16
            a = 500 * (X - Y)
            b = 200 * (Y - Z)

            # Asignar valores al array LAB
            lab[i, j] = [L, a, b]

    return lab

#Cuantizacion
def cuantizar(img, L):
    # Crear una imagen de salida con la misma forma que la imagen original
    img_cuantizada = np.zeros_like(img, dtype=np.uint8)
    
    # Calcular el número máximo de niveles
    max_val = (2 ** L) - 1
    
    # Recorrer cada píxel y aplicar la cuantización
    for i in range(img.shape[0]):  # Recorrer las filas (alto)
        for j in range(img.shape[1]):  # Recorrer las columnas (ancho)
            # Cuantizar el valor del píxel
            img_cuantizada[i, j] = np.floor((img[i, j] / 255.0) * max_val)
    
    return img_cuantizada

def binarizar(imagen, umbral):
    imagen_binaria = np.where(imagen > umbral, 1.0, 0.0)
    return imagen_binaria