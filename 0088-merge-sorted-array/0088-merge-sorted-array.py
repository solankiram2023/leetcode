class Solution:
    def merge(self, n1: List[int], m: int, n2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.

        """
        i, j, k = m - 1, n - 1, n + m -1

        while j >= 0:
            if i  >= 0 and n1[i] > n2[j]:
                n1[k] = n1[i]
                i -= 1
            else:
                n1[k] = n2[j] 
                j -= 1
            k -= 1
