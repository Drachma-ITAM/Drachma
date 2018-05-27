from robot import *

def mejorRangoMedidaTiemp():
    """
    Con pruebas vera cual es es juego perfecto de acuerdo a un historial entregado
    """
    cont=1
    ganador=(0, 0, 0, 0, 0, 0, 0,0,'',0)
    while cont<60:
        robotMin= robot(cont,'min',1000)
        robotSec= robot(cont,'sec',1000)
        #print cont, robotMin[2],robotSec[2],ganador[2]
        if robotMin[2]>ganador[2]:
            ganador=robotMin+(cont, )
        if robotSec[2]>ganador[2]:
            ganador=robotSec+(cont,)
        cont+=1
    return ganador