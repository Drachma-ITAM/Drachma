import sys, os
import ast

def tiempoMin (min):
    """
    Tomara el historial de los pings cada 2 sec y los trasformara de acuerdo a los min necesarios
        :param min: Minutos
        :return: nombre del archivo creado
    """
    MYDIR = os.path.dirname(__file__)
    pathname = os.path.dirname(sys.argv[0])
    archivo = "preciosETH"
    with open(os.path.join(MYDIR, archivo+".txt")) as f:
        content = f.readlines()
        for i in range(0, len(content),int(min)*30):
            line = content[i]
            jason=ast.literal_eval(line)
            nombre=str(min)+'min.txt'
            with open(pathname+"/"+nombre, 'a') as f:
                print >> f, jason['ETH']
        return nombre