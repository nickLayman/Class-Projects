import unittest
import HWPrograms as h


class MyTestCase(unittest.TestCase):
    def test_divides_1(self):
        self.assertTrue(h.divides(1, 2))

    def test_divides_2(self):
        self.assertTrue(h.divides(2, 6))


if __name__ == '__main__':
    unittest.main()
