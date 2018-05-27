
def decision(disCir,y2,m,monedero,presupuesto):
    """
    Te dice cuanto % tienes que invertir o comprar
        :param disCir:  Distancia del circulo 
        :param y2: Precio de la criptomoneda 
        :param m: Pendiente
        :param monedero: Cuantas criptomoneas se tiene (solo con la que se esta trabajando)
        :param presupuesto: Cuanto dinero se tienen para invertir
        :returns: monedero, presupuesto
    """
    porciento = (m/disCir)
    if porciento>0: #si la pendiente es positiva
        if monedero>0: #difiere aqui
            valorMonedero=monedero*y2
            porcienMonedero = porciento*valorMonedero #% de monedero a invertir representado en precio
            trueque = porcienMonedero/y2
            venta=round(float(trueque*y2),8)
            if(monedero-round(float(venta/y2),8))>0:
                monedero-= round(float(venta/y2),8)
                presupuesto += venta
                return monedero,presupuesto
    else:
        if presupuesto > 0:
            inversion = porciento*-presupuesto
            if presupuesto - inversion >0:
                compra=round(float(inversion/y2),8)
                presupuesto -= inversion
                monedero +=compra
                return monedero, presupuesto

