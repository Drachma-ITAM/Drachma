import unittest
from biblioteca import robot

class TestMyModule(unittest.TestCase):
    def test_robot(self):
        self.assertEqual(robot.robot(1000,"min",1000), (1000, 0.0, 1000.0, 0, 0.0, 1944.14844, 0.0, 99, 'min'))
        #self.assertTrue(True)
        
if __name__ == "__main__":
    unittest.main()