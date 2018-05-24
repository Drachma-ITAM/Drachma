import unittest
from biblioteca import decision

class TestMyModule(unittest.TestCase):
    def test_decision(self):
        self.assertEqual(decision.decision(100,100,1,0,1000), (0, 1000))

if __name__ == "__main__":
    unittest.main()