import unittest
from biblioteca import decisionPerf

class TestMyModule(unittest.TestCase):
    def test_decisionPer(self):
        self.assertEqual(decisionPerf.decisionPerf(1000,900,-100,0,1000), (0, 1000))

if __name__ == "__main__":
    unittest.main()