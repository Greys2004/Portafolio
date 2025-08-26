
import numpy as np

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

def cuantizar_pixel(pixel, nivel_actual, nivel_deseado):
    max_actual = (2 ** nivel_actual) - 1
    max_deseado = (2 ** nivel_deseado) - 1
    return np.round((pixel / max_actual) * max_deseado).astype(np.uint8)

def cuantizar_imagen(img, nivel_actual, nivel_deseado):
    alto, ancho = img.shape
    imagenCuantizada = np.zeros((alto, ancho), dtype=np.uint8)

    for i in range(alto):
        for j in range(ancho):
            pixel = img[i, j]
            imagenCuantizada[i, j] = cuantizar_pixel(pixel, nivel_actual, nivel_deseado)

    return imagenCuantizada

def correlacion1D(f, h):
    #Comprobar que h (kernel) no sea mayor a f (señal)
    if len(h) > len(f):
        print("Debe ser menor o igual el tamaño de kernel al tamaño de la señal")
    else:
        len_f = len(f)
        len_h = len(h)
        
        len_result = len_f - len_h + 1
        result = np.zeros(len_result)
        
        for n in range(len_result):
            for k in range(len_h):
                result[n] += f[n + k] * h[k]
        
        return result

def convulsion1D(f,h):
    if len(h) > len(f):
        print("Debe ser menor o igual el tamaño de kernel al tamaño de la señal")
    else:
        return correlacion1D(f, h[::-1])

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
    
def kernel_gaussiano(size, sigma):
    k = size // 2
    x, y = np.meshgrid(np.arange(-k, k + 1), np.arange(-k, k + 1))
    kernel = (1 / (2 * np.pi * sigma ** 2)) * np.exp(-(x ** 2 + y ** 2) / (2 * sigma ** 2))
    kernel /= np.sum(kernel) 
    return kernel

def ruidoSalPimienta(img, ps, pp):
    """
    Agrega ruido de sal y pimienta a una imagen.
    ps: probabilidad de sal (valor blanco)
    pp: probabilidad de pimienta (valor negro)
    """
    epsilon = np.random.uniform(0, 1, img.shape)
    alto, ancho = img.shape
    img_out = np.zeros((alto, ancho), dtype=float)

    for i in range(alto):
        for j in range(ancho):
            if epsilon[i, j] < ps:
                img_out[i, j] = 0 
            elif epsilon[i, j] > 1 - pp:
                img_out[i, j] = 255 
            else:
                img_out[i, j] = img[i, j]

    return img_out

def agregar_ruido_gaussiano(imagen, media=0, desviacion=200):
    """
    Agrega ruido gaussiano a una imagen en escala de grises.
    media: media del ruido (centro)
    desviacion: desviación estándar del ruido (amplitud)
    """
    ruido = np.random.normal(media, desviacion, imagen.shape)
    imagen_con_ruido = imagen + ruido
    imagen_con_ruido = np.clip(imagen_con_ruido, 0, 255)
    return ruido, imagen_con_ruido

def kernel_gaussiano(size, sigma):
    k = size // 2
    x, y = np.meshgrid(np.arange(-k, k + 1), np.arange(-k, k + 1))
    kernel = (1 / (2 * np.pi * sigma ** 2)) * np.exp(-(x ** 2 + y ** 2) / (2 * sigma ** 2))
    kernel /= np.sum(kernel) 
    return kernel

def estiramientoContrasteLineal(img, smin, smax):
    img_min = np.min(img)
    img_max = np.max(img)
    
    alto, ancho = img.shape
    
    imagen = np.zeros((alto, ancho), dtype= float)
    
    for i in range(alto):
        for j in range(ancho):
            imagenEstirada = int (smin + ((img[i, j] - img_min) * (smax - smin)) / (img_max - img_min) )
            
            imagen[i, j] = imagenEstirada
            
    return imagen

def mix_min (rk, r_min, r_max,s_min, s_max):
    return s_min + ((rk - r_min) * (s_max - s_min)) / (r_max - r_min)


def estiramientoContrastePorTramos(img, r_valores, s_valores):
    """
        Parametros:
            img: Imagen de entrada en escala de grises.
            r_valores: Lista de intensidades de entrada para el estiramiento.
            s_valores: Lista de intensidades de salida correspondientes.
    """
    
    if len(r_valores) != len(s_valores):
        raise ValueError("r_valores y s_valores deben tener la misma longitud")

    alto, ancho = img.shape
    img_out = np.zeros((alto, ancho), dtype=float)
    num_r = len(r_valores)

    for i in range(alto):
        for j in range(ancho):
            pixel = img[i, j]

            for k in range (num_r -1):
                r_min = r_valores[k]
                r_max = r_valores[k + 1]
                
                s_min = s_valores[k]
                s_max = s_valores[k + 1]
                
                if pixel >= r_min and pixel <= r_max:
                    sk = mix_min(pixel, r_min, r_max, s_min, s_max)
                    break
            
            img_out[i, j] = sk
            
    return img_out

def agregar_ruido_gaussiano(imagen, media=0, desviacion=200):
    """Agrega ruido gaussiano a una imagen en escala de grises."""
    ruido = np.random.normal(media, desviacion, imagen.shape)
    imagen_con_ruido = imagen + ruido
    return ruido, imagen_con_ruido

def ruidoSalPimienta(img, ps, pp):
    epsilon = np.random.uniform(0, 1, img.shape)
    
    alto, ancho = img.shape
    img_out = np.zeros((alto, ancho), dtype= float)
    
    for i in range(alto):
        for j in range(ancho):
            if epsilon[i, j] < ps:
                img_out[i, j] = 0
            elif epsilon[i, j] > 1 - pp:
                img_out[i, j] = 255
            else:
                img_out[i, j] = img[i, j]
                
    return img_out

def histograma(img):
    ancho, alto = img.shape
    hist = np.zeros(256)
    
    for x in range(ancho):
        for y in range(alto):
            rk = int(img[x,y]) # Intensidad de la imagen
            hist[rk] += 1
    return hist

def histogramaNormalizado(img):
    hist = histograma(img)
    hist = hist / (img.shape[0] * img.shape[1])
    return hist

def acumulado(hist):
    acumulado = [hist[0]]
    for i in range(1, len(hist)):
        acumulado.append(acumulado[-1] + hist[i])
    return np.array(acumulado)

def ecualizacion_histograma(img):
    hist_norm = histogramaNormalizado(img)
    acumulad = acumulado(hist_norm) 
    
    # Tabla LookUpTable
    lut = 255*acumulad
    
    img_eq = np.zeros_like(img)
    for x in range(img.shape[0]):
        for y in range(img.shape[1]):
            img_eq[x, y] = lut[int(img[x, y])]
    
    return img_eq, lut

def negativa(img):
    h, w = img.shape
    
    img_out = np.zeros_like(img)
    
    for i in range(h):
        for j in range(w):
            rk = img[i, j]
            img_out[i, j] = 255 - rk
            
    return img_out

def logaritmica(img,c):
    h, w = img.shape
    
    img_out = np.zeros_like(img, dtype=np.float32)
    
    for i in range(h):
        for j in range(w):
            rk = img[i, j]
            img_out[i, j] = c * np.log(1 + rk)
            
    return img_out

def gamma(img,c,g):
    h, w = img.shape
    
    img_out = np.zeros_like(img, dtype=np.float32)
    
    # Normalizar la imagen
    for i in range(h):
        for j in range(w):
            rk = img[i, j]
            img_out[i, j] = rk / 255.0
            
    # Aplicar la transformación gamma
    for i in range(h):
        for j in range(w):
            rk = img_out[i, j]
            img_out[i, j] = c * (rk ** g)
    
    # Desnormalizar la imagen
    for i in range(h):
        for j in range(w):
            rk = img_out[i, j]
            img_out[i, j] = rk * 255.0
            
    return img_out

def binarizar(imagen, umbral):
    imagen_binaria = np.where(imagen > umbral, 1.0, 0.0)
    return imagen_binaria

def erosion(imagen, kernel):
    img_h, img_w = imagen.shape
    k_h, k_w = kernel.shape
    pad_h = k_h // 2
    pad_w = k_w // 2

    resultado = np.zeros_like(imagen)

    # Hacemos un padding a la imagen para evitar que se pierdan bordes
    imagen_padded = np.pad(imagen, ((pad_h, pad_h), (pad_w, pad_w)), mode='constant', constant_values=0)

    for i in range(img_h):
        for j in range(img_w):
            region = imagen_padded[i:i + k_h, j:j + k_w]
            if np.array_equal(region * kernel, kernel):
                resultado[i, j] = 1.0
            else:
                resultado[i, j] = 0.0
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
            else:
                resultado[i, j] = 0.0
    return resultado

def apertura(imagen, kernel):
    return dilatacion(erosion(imagen, kernel), kernel)

# Cierre
def cierre(imagen, kernel):
    return erosion(dilatacion(imagen, kernel), kernel)

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