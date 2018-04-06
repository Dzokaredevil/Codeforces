using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        public class HeapSorter
        {
            private int[] _arr;
            private int _heapSize;

            public HeapSorter(int[] arr)
            {
                _arr = new int[2 * arr.Length];
                Array.Copy(arr, 0, _arr, 0, arr.Length);
                _heapSize = arr.Length;
            }

            private static void change(int[] arr, int idx1, int idx2)
            {
                int tmp = arr[idx2];
                arr[idx2] = arr[idx1];
                arr[idx1] = tmp;
            }

            private static int parent(int idx)
            {
                if (idx <= 2)
                    return 0;

                return idx / 2;
            }

            private static int left(int idx)
            {
                if (idx == 0)
                    return 1;

                return 2 * idx;
            }

            private static int right(int idx)
            {
                if (idx == 0)
                    return 2;

                return 1 + 2 * idx;
            }

            private static void maxHeapify(int[] arr, int idx, int heapSize)
            {
                int largest = idx;
                int l = left(idx);
                int r = right(idx);

                if (l < heapSize && arr[l] > arr[largest])
                {
                    largest = l;
                }
                if (r < heapSize && arr[r] > arr[largest])
                {
                    largest = r;
                }
                if (largest != idx)
                {
                    int tmp = arr[idx];
                    arr[idx] = arr[largest];
                    arr[largest] = tmp;
                    maxHeapify(arr, largest, heapSize);
                }
            }

            private static bool IsMaxHeap(int[] arr, int idx)
            {
                if (arr.Length < idx)
                    return true;

                int lIdx = left(idx);
                int rIdx = right(idx);

                bool gtLeft = true, gtRight = true;
                
                if (lIdx < arr.Length) {
                    gtLeft = arr[idx] >= arr[lIdx] && IsMaxHeap(arr, lIdx);
                }

                if (rIdx < arr.Length) {
                    gtRight = arr[idx] >= arr[rIdx] && IsMaxHeap(arr, rIdx);
                }

                return gtLeft && gtRight;
            }
            private static bool IsMaxHeap1(int[] arr)
            {
                for (int i = arr.Length - 1; i > 0; i--)
                    if (arr[parent(i)] < arr[i])
                        return false;

                return true;
            }

            private static void BuildMaxHeap(int[] arr)
            {
                int heapSize = arr.Length;
                for (int i = heapSize / 2; i >= 0; i--)
                {
                    maxHeapify(arr, i, heapSize);
                }
            }

            private static void HeapSort(int[] arr)
            {
                BuildMaxHeap(arr);
                int heapSize = arr.Length;
                for (int i = arr.Length - 1; i > 0; i--)
                {
                    int tmp = arr[0];
                    arr[0] = arr[--heapSize];
                    arr[heapSize] = tmp;
                    maxHeapify(arr, 0, heapSize);
                }
            }

            public bool IsHeapSorted()
            {
                return IsMaxHeap1(_arr);
            }

            public void HeapSort()
            {
                HeapSort(_arr);
            }

            public int HeapMax()
            {
                return _arr[0];
            }

            public int HeapExtractMax()
            {
                int max = _arr[0];
                _heapSize--;
                change(_arr, 0, _heapSize - 1);
                maxHeapify(_arr, 0, _heapSize);
                return max;
            }

            public void IncreaseKey(int idx, int key)
            {
                if (_arr[idx] < key)
                    return;
                _arr[idx] = key;
                for (int i = idx; i > 0; i = parent(i)) {
                    if (_arr[i] > _arr[parent(i)])
                        change(_arr, i, parent(i));
                }
            }

            public void MaxHeapInsert(int key)
            {
                IncreaseKey(_heapSize++, key);
            }
        }

        public class NonConfirmator
        {
            public static UInt64 getPosition(UInt64 n, UInt64 k)
            {
                if ((n+1)/2 >= k) {
                    return 2 * k - 1;
                }
                return k * 2 - ((n + 1) / 2) * 2;
            }
        }

        static void Main(string[] args)
        {
            string str = Console.ReadLine();
            string[] nums = str.Split(new char[] { ' ' });

            Console.WriteLine(NonConfirmator.getPosition(UInt64.Parse(nums[0]), UInt64.Parse(nums[1])));
            Console.ReadLine();
        }
    }
}
