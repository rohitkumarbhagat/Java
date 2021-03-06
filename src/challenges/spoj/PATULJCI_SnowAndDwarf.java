package challenges.spoj;

/**
 * @author rohitkumar
 * 
 *         https://www.spoj.pl/problems/PATULJCI/
 * 
 *         solution url =
 *         http://apps.topcoder.com/forums/?module=Thread&threadID
 *         =653017&start=45&mc=87
 * 
 *         I'll describe the O(N + M log N) solution, because I think it's
 *         really nice too.
 * 
 *         For now, forget about the problem we are solving.
 * 
 *         Suppose we had a sequence of integers and an algorithm like this:
 *         while there are different numbers in the sequence select any two
 *         different numbers from the sequence and erase them For example if the
 *         sequence were: 1 2 3 1 2 3 2 3 the algorithm could have done this: 1
 *         2 3 1 2 3 2 3 --> 3 1 2 3 2 3 -> 1 3 2 3 -> 3 3
 * 
 *         Note that we could also end up with other sequences if we selected
 *         pairs in a different way.
 * 
 *         Let candidate be the number that is left in a sequence (3 in the
 *         example above). Let count be the number of numbers left in a sequence
 *         (2 in the example above).
 * 
 *         The cool thing about the algorithm is that if there is a number that
 *         appears more than N/2 times in the sequence it must end up as a
 *         candidate no matter the way we select pairs. Intuitively, we don't
 *         have enough other numbers to kill all of the candidate numbers.
 * 
 *         So we can choose our own way to select pairs. Let's do it recursively
 *         like this. 1) Split the sequence S in two halves L and R. 2) Run the
 *         recursive algorithm on sequence L to get L.candidate and L.count 3)
 *         Run the recursive algorithm on sequence R to get R.candidate and
 *         R.count 4) Kill the remaining pairs among L.count + R.count numbers
 *         that are left.
 * 
 *         The step #4 can be done very efficiently like this: if L.candidate ==
 *         R.candidate S.candidate = L.candidate S.count = L.count + R.count
 *         else if L.count > R.count S.candidate = L.candidate S.count = L.count
 *         - R.count else S.candidate = R.candidate S.count = R.count - L.count
 *         end end
 * 
 * 
 *         So, we can use this idea to build the interval tree, every node
 *         containing info (candidate and count) about the subsequence it
 *         represents.
 * 
 *         We can also query the interval tree to get candidate number for any
 *         interval [A, B]. Then we can use binary search to count the number of
 *         appearances of the candidate number in the interval and determine if
 *         the picture is pretty or not.
 * 
 * 
 */
public class PATULJCI_SnowAndDwarf {

}
