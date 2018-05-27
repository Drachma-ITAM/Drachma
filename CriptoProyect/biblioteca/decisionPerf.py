
def decisionPerf(y1,y2,m,monedero,presupuesto):
    """
    Saca el juego perfecto en cuanto a ventas y compras en los puntos mas altos o mas bajos
        :param y1: precio anterios 
        :param y2: precio actual
        :param m: pendiente
        :param monedero: criptomonedas adquiridas
        :param presupuesto: dinero a invertir
        :returns: monedero, presupuesto
    """
    if m>0: #si la pendiente es positiva
        monedero+= round(float(presupuesto/y2),8)
        presupuesto += monedero*y1
        monedero-=monedero   
    else:
        if presupuesto > 0:
            if monedero > 0:
                presupuesto += round(float(monedero*y2),8)
                monedero += monedero*y1
                presupuesto -=presupuesto
    return monedero, presupuesto