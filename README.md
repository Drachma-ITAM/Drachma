Running a single test module:
    sudo python -m unittest test.nombre_archivo
    
    Ejemplo:
        sudo python -m unittest test.test_decision

Running a single test case or test method:
    sudo python -m unittest archivo_padre.test_archivo.objeto
    sudo python -m unittest archivo_padre.test_archivo.objeto.metodo

Running all tests (will find and run tests in the test directory if they are named test*.py):
    sudo python -m unittest discover

More:
If you named the subdirectory tests, use:
    sudo python -m unittest discover -s tests, 
If you named the test files file_test.py, use:
    sudo python -m unittest discover -s tests -p 
'*test.py' File names can use underscores but not dashes.

no se puede tener prueba unitaria el modelo 1:
debido a que se conecta en tiempo real

import unittest
from biblioteca import modelo_1

class TestMyModule(unittest.TestCase):
    def test_modelo_1(self):
        self.assertEqual(modelo_1.modelConectBitso(1000), (0.0, 1000))

if __name__ == "__main__":
    unittest.main()

Como se puede tener prueba unitaria del robot?
import unittest
from biblioteca import robot

class TestMyModule(unittest.TestCase):
    def test_robot(self):
        self.assertEqual(robot.robot(1000,"min",1000), ((298.88736473124845,4017.68023168,4316.567596411249,26.5376686656219,16265.8131383,0.0,16265.8131383),9,"min"))
        
if __name__ == "__main__":
    unittest.main()