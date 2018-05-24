import unittest
from biblioteca import modelo_prueba

class TestMyModule(unittest.TestCase):
    def test_modPrueba(self):
        self.assertEqual(modelo_prueba.modPrueba("preciosETH.txt",1000,100), (1904.3958147127719, 0.1252606499999996, 3228.400885212768, 66.47189779783398, 0.0, 4856.790601994769, 0.0))
        
if __name__ == "__main__":
    unittest.main()