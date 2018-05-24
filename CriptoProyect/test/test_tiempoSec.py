import unittest
from biblioteca import tiempoSec

class TestMyModule(unittest.TestCase):
    def tiempoSec(self):
        self.assertEqual(tiempoSec.tiempoSec(1000),"1000sec.txt")

if __name__ == "__main__":
    unittest.main()