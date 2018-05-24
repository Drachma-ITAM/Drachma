from tiempoMin import *
from tiempoSec import *
from mejorDist import *
from modelo_prueba import *

def robot (rangTiem,medidasTiem,dinero):
    """
    Robot que se dedica a hacer pruebas con un rango de tiempo para ver un resultado de acurdo a un presupuesto designado
        :param rangTiem: segundos o minutos
        :param medidasTiem: en minutos o segundos
        :param dinero: inversion inicial
        :return: modelo de prueba + distancia+ medida de tiempo
    """
    if medidasTiem =='min':
        archivo = tiempoMin(str(rangTiem))
        print archivo
    elif medidasTiem =='sec':
        archivo = tiempoSec(str(rangTiem))
        print archivo
    else:
        return 'Eliga entre min o sec'
    disCir= mejorDis(archivo,dinero)[0]
    #print disCir
    res= modPrueba(archivo,dinero,disCir)
    MYDIR = os.path.dirname(__file__)
    os.remove(MYDIR+"/"+archivo)
    return res+(disCir,medidasTiem)

print robot(1000,"min",1000)