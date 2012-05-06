package challenges.spoj;

/**
 * @author rohitkumar
 * 
 * 
 *         Nowdays you just can't predict what'll fall on your head the next
 *         day.. Because we don't care about the nature, it is now striking
 *         back: it's raining parabolas!
 * 
 *         The parabolas that are falling are given in form of quadratic
 *         functions: f(x) = ax2 + bx + c. The ground can be defined as a line
 *         with N blocks, numbered from 0 to N-1, initially having height 0. At
 *         some point, a block can have some positive height, but when it
 *         exceeds 10006 ( we don't actually know why, but measurements have
 *         shown it is a weird regularity.. ) it falls back to 0. When a
 *         parabola falls on some block, it interacts with its current
 *         configuration ( the parabolas that have fallen there before it ) by
 *         summing with it. More precisely, if we are given an interval [x0, x1]
 *         in which the next parabola will fall, and the function of our
 *         parabola is f(x) ( defined above ), some block i ( x0 <= i <= x1 ),
 *         with height hi, the new height of that block becomes (hi + f(i))
 *         modulo 10007.
 * 
 *         Today you somehow came in possesion of some sort of schedule which
 *         defines the order in which the parabolas will fall on the ground.
 *         Apart from that, you're interested total heights ( sums of heights )
 *         of consecutive blocks of ground. When we want to find the total
 *         height of some interval [x0, x1], we're looking for the sum of hi for
 *         all i ( x0 <= i <= x1 ) modulo 10007. Before the first parabola
 *         falls, the ground is flat ( all heights are 0 ). Input
 * 
 *         The first line of input contains two integers: N and M ( 1 <= N, M <=
 *         100000 ). N specifies the number of blocks on the floor, and M is the
 *         number of queries. Each of the next M lines contains a query. As we
 *         already said, we have two types of queries of form:
 * 
 *         0 x0 x1 a b c (0 <= x0 <= x1 < N, 0 <= a, b, c <= 10006, all integers
 *         )
 * 
 *         this type of query just tells you that a parabola has
 * 
 *         fallen into the interval [x0, x1], and its function is f(x) = ax2 +
 *         bx + c
 * 
 * 
 * 
 *         1 x0 x1 ( 0 <= x0 <= x1 < N, all integers )
 * 
 *         this is the type of query you have to answer - output the sum of
 *         heights
 * 
 *         of all the blocks from interval [x0, x1] modulo 10007
 * 
 * 
 * 
 *         Output
 * 
 *         For each query of type 1, output a single line containing the sum of
 *         all the heights in the given interval modulo 10007.
 * 
 *         Example
 * 
 *         Input: 10 2 0 0 9 1 0 0 1 0 3 Output: 14
 * 
 *         (the sum of the first 4 squares ( from 0 to 3 ) is 14 )
 * 
 * 
 */
public class RPAR_RainingParabolas {

}
