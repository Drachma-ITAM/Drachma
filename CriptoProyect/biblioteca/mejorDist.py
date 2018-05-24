from modelo_prueba import *

def mejorDis(archivo,dinero):
    """
    Busca la mejor distancia en 100 pruebas de acuerdo al presupuesto designado
        :param archivo: historial de precios
        :param dinero:  inversion inicial
        :return: iteracion ganadora + resultodado del modelo prueba
    """
    cont=1
    ganadorMod=(0, 0, 0, 0, 0, 0, 0)
    while cont<100:
        Mod= modPrueba(archivo,dinero,cont)
        if Mod[2]>ganadorMod[2]:
            ganadorMod=(cont,)+Mod
        cont+=1
    return ganadorMod
