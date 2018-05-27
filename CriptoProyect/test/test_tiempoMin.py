import unittest
from biblioteca import tiempoMin

class TestMyModule(unittest.TestCase):
    def tiempoMin(self):
        self.assertEqual(tiempoMin.tiempoMin(1000),"1000min.txt")

if __name__ == "__main__":
    unittest.main()