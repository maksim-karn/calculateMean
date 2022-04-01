# Calculate mean

After thinking about the problem, I chose this solution.

Initially, there was an idea to queue the sum of a new number with the previous one so that when calculating the average, it would be enough to subtract the final sum from the initial one and divide by the number of elements.
But the problem was storing ever-increasing numbers.

When calculating the average, I did not divide each number by the amount in order to reduce memory costs.
`getAverage()` method uses `long` for storing sum. This is enough to add the maximum numbers int.
Dividing each number by the total would take more CPU time.