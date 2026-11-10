package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

/*
Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
Allocate books in such a way that:
1. Each student gets at least one book.
2. Each book should be allocated to only one student.
3. Book allocation should be in a contiguous manner.

You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1
*/

import java.util.Scanner;

public class BookAllocationProblem {
    public static int findMax(int[] arr) {
        int max = arr[0];

        for(int n : arr) {
            if(n > max) {
                max = n;
            }
        }

        return max;
    }
 
    public static int sumArr(int[] arr) {
        int sum = 0;

        for(int n : arr) {
            sum += n;
        }

        return sum;
    }

    public static boolean canAllocateBooks(int[] books, int students, int maxPages) {
        int pages = 0;
        int allotedStudents = 1;

        for(int book : books) {
            if(pages + book <= maxPages) {
                pages += book;
            } else {
                allotedStudents++;
                pages = book;
            }
        }

        return allotedStudents <= students;
    }

    // Brute Approach
    // Time Complexity = O(N * (sum(arr) - max(arr)))
    // Space Complexity = O(1)
    public static int bruteApproach(int[] books, int students) {
        if(students > books.length) {
            return -1;
        }

        int low = findMax(books);
        int high = sumArr(books);

        for(int i=low; i<=high; i++) {
            if(canAllocateBooks(books, students, i)) {
                return i;
            }
        }

        return -1;
    }


    // Optimal Approach
    // Time Complexity = O(N * Log(sum(arr) - max(arr)))
    // Space Complexity = O(1)
    public static int optimalApproach(int[] books, int students) {
        if(students > books.length) {
            return -1;
        }

        int low = findMax(books);
        int high = sumArr(books);

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(canAllocateBooks(books, students, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        int[] books = new int[n];
        System.out.println("Enter number of pages for " + n + " books: ");
        for(int i=0; i<n; i++) {
            books[i] = sc.nextInt();
        }

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        // Brute Approach
        System.out.println("Minimum of maximum pages allocated to student is: " + bruteApproach(books, students));

        // Optimal Approach
        System.out.println("Minimum of maximum pages allocated to student is: " + optimalApproach(books, students));

        sc.close();
    }
}