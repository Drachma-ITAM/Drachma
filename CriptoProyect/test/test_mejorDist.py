import unittest
from biblioteca import mejorDist

class TestMyModule(unittest.TestCase):
    def test_modPrueba(self):
        self.assertEqual(mejorDist.mejorDis("preciosETH.txt",1000), (99, 2071.7706847399936, 0.10396837000000037, 3170.7163556399973, 63.4046887932559, 0.0, 5000.760063626798, 0.0))
        
if __name__ == "__main__":
    unittest.main()