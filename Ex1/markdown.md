Kullback-Leibler (KL) divergence is a measure of how one probability distribution diverges from a second, expected probability distribution. It is particularly useful in fields such as information theory, machine learning, and statistics. Here's a detailed explanation:

### Definition

Given two probability distributions \( P \) and \( Q \) defined on the same probability space, the KL divergence from \( Q \) to \( P \) is defined as:

\[ D_{KL}(P \parallel Q) = \sum_{i} P(i) \log \left(\frac{P(i)}{Q(i)}\right) \]

For continuous probability distributions, it is defined as:

\[ D_{KL}(P \parallel Q) = \int_{-\infty}^{\infty} p(x) \log \left(\frac{p(x)}{q(x)}\right) dx \]

where \( p(x) \) and \( q(x) \) are the probability density functions of \( P \) and \( Q \), respectively.

### Interpretation

- **Non-Symmetry**: KL divergence is not symmetric, meaning \( D_{KL}(P \parallel Q) \neq D_{KL}(Q \parallel P) \).
- **Non-Negativity**: KL divergence is always non-negative, \( D_{KL}(P \parallel Q) \geq 0 \), with equality if and only if \( P = Q \) almost everywhere.
- **Asymmetry**: Since it measures the "extra" information needed to approximate \( P \) using \( Q \), it does not serve as a true "distance" metric but rather as a divergence measure.

### Applications

1. **Machine Learning**: KL divergence is used in various algorithms, such as in the training of variational autoencoders and in reinforcement learning.
2. **Information Theory**: It quantifies the inefficiency of assuming the distribution \( Q \) when the true distribution is \( P \).
3. **Statistics**: KL divergence can be used in hypothesis testing and in measuring the difference between observed data and a model.

### Example Calculation

For two discrete distributions \( P \) and \( Q \) over a finite set \( X \):

1. **P**: \(\{0.4, 0.6\}\)
2. **Q**: \(\{0.5, 0.5\}\)

The KL divergence \( D_{KL}(P \parallel Q) \) would be:

\[ D_{KL}(P \parallel Q) = 0.4 \log \left(\frac{0.4}{0.5}\right) + 0.6 \log \left(\frac{0.6}{0.5}\right) \]

Calculating the logarithms and the resulting values:

\[ 0.4 \log (0.8) + 0.6 \log (1.2) \approx 0.4 \times (-0.09691) + 0.6 \times 0.18232 \]
\[ \approx -0.038764 + 0.109392 \approx 0.070628 \]

So, \( D_{KL}(P \parallel Q) \approx 0.0706 \).

### Conclusion

KL divergence provides a robust tool for comparing probability distributions, giving insights into how much one distribution diverges from another. Its applications span many domains, making it a fundamental concept in both theoretical and applied statistics and machine learning.