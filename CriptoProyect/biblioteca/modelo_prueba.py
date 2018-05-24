from decision import *
from decisionPerf import *
import sys, os
import ast

def modPrueba(archivo,dinero,disCir):
    """
    Deacuerdo a un historial hara %compras/ventas
        :param archivo: historial con los precios (precio debe de encontrarce en el primer lugar de la linea)
        :param dinero: cuanto dinero se cuenta
        :param disCir: distancia del circulo
        :returns: presupuesto,monedero,total de dinero en monedas e inversion,aproximacion, criptomonedas, presupuestoperfectofinal, valor del monedero
    """
    MYDIR = os.path.dirname(__file__)
    presupuesto = dinero
    aproximacion =0
    ##Programa
    with open(os.path.join(MYDIR, archivo)) as f:
        #el if else depende si se comporta como diccionario o como float
        if type(ast.literal_eval(f.readline())) == type(0.0):
            y1= ast.literal_eval(f.readline())
        else:
            y1= ast.literal_eval(f.readline()).get('ETH')
        x1=0.0
        x2=0.0
        monedero=0.0
        for line in f:
            if type(ast.literal_eval(line)) == type(0.0):
                y2=ast.literal_eval(line)
            else:
                y2=ast.literal_eval(line).get('ETH')
            x2+=1
            if(y2-y1 >0) | (y2-y1<0): #si el cambio es positivo o negativo
                m=(y2-y1)/(x2-x1)   #pendiente
                res = decision(disCir,y2,m,monedero,presupuesto)
                resPerf = decisionPerf(y1,y2,m,monedero,presupuesto)
                if res != None:
                    monedero = res[0]
                    presupuesto= res[1]
                    aproximacion =((presupuesto+(monedero*y2))/(resPerf[1]+(resPerf[0]*y2)))*100
                y1=y2
                x1=x2
        return presupuesto,monedero,presupuesto+(monedero*y2),aproximacion, resPerf[0], resPerf[1], resPerf[0]*y2


#print modPrueba("preciosETH.txt",1000,100)