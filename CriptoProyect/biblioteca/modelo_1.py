import time
import math
import datetime
import itertools
from datetime import datetime
import bitso

from decision import *

def modelConectBitso(dinero):
    """
    Se conecta a bitso para sacar el precio y apartir de eso decidir %compra/venta
        :param dinero: la cantidad a invertir
    """
    curren = 'eth_mxn'
    api = bitso.Api()
    tick = api.ticker(curren)
    presupuesto = dinero
    costo =float(tick.last)
    y1=float(api.ticker(curren).last) #primer valor
    x1=0.0
    x2=0.0
    monedero=0.0
    valorMonedero = 0.0
    while costo != 0:
        tick = api.ticker(curren)
        y2=float(tick.last)
        time.sleep(44)
        ##Programa
        y2=float(api.ticker(curren).last)
        x2+=1
        if(y2-y1 >0) | (y2-y1<0): #si el cambio es positivo o negativo
            m=(y2-y1)/(x2-x1)   #pendiente
            res = decision(100,y2,m,monedero,presupuesto)
            #resPerf = decisionPerf(y1,y2,m,monedero,presupuesto)
            if res != None:
                monedero = res[0]
                presupuesto= res[1]
                #aproximacion =((presupuesto+(monedero*y2))/(resPerf[1]+(resPerf[0]*y2)))*100
                print presupuesto,monedero,presupuesto+(monedero*y2)
            y1=y2
            x1=x2
