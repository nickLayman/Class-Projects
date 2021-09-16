import sympy


def divides(a, b):
    """
    Write a code to check if a|b is true or not.
    (Once you have a draft,
    feel free to Google to see if there’s a shorter solution.)
    """
    if a == 0 and b == 0:
        return True
    if a == 0:
        return False
    if b < 0 or a < 0:
        return divides(abs(a), abs(b))
    while b >= a:
        b -= a
    return b == 0


def divides2(a, b):
    """
    Write a code to check if a|b is true or not.
    (Once you have a draft,
    feel free to Google to see if there’s a shorter solution.)
    """
    if a == 0 and b == 0:
        return True
    if a == 0:
        return False
    return (b % a) == 0


def lcm(a, b):
    """
    Write a code to find lcm of any two given positive integers.
    Then use lcm to find the gcd of the two integers.
    """
    if a < 0 or b < 0:
        return lcm(abs(a), abs(b))
    # the description specifies positive integers
    if a == 0 or b == 0:
        return 0
    else:
        larger = max(a, b)
        m = larger
        while not (m % a == 0 and m % b == 0):
            m += larger
        return m


def gcd(a, b):
    """
    Write a code to find lcm of any two given positive integers.
    Then use lcm to find the gcd of the two integers.
    """
    # added the 0 case
    # but it is unnecessary when positive integers is assumed
    if a < 0 or b < 0:
        return gcd(abs(a), abs(b))
    if a == 0 and b == 0:
        raise Exception("gcd(0, 0) is not defined.")
    if a == 0 or b == 0:
        return max(a, b)
    return a*b/lcm(a, b)


def gcd2(a, b):
    """
    Write a code to implement the Euclidean algorithm to find gcd.
    """
    if a < 0 or b < 0:
        return gcd(abs(a), abs(b))
    if a == 0 and b == 0:
        raise Exception("gcd(0, 0) is not defined")
    if a == 0 or b == 0:
        return max(a, b)
    if a < b:
        return gcd(a, b % a)
    if b < a:
        return gcd(b, a % b)
    return a


def goldbach(upper):
    """
    Another famous number theory conjecture is Goldbach conjecture.
    This conjecture states that every even integer greater than two is
    is the sum of two prime numbers. The conjecture has been tested
    up to 4*10^17. Can you think of an algorithm to test it yourself
    for large numbers (maybe not 4*10^17 large, but larger than 1000)?

    This method only prints things, it has no return
    """
    primes = list(sympy.primerange(0, upper))
    for n in range(4, upper, 2):
        i, j = 0, len(primes) - 1
        while primes[i] + primes[j] != n:
            if primes[i] + primes[j] < n:
                i += 1
            elif primes[i] + primes[j] > n:
                j -= 1
        # prints only the first solution it finds
        print(f"{n} = {primes[i]} + {primes[j]}")


def sieve(n):
    """
    Write a code to implement the Eratosthenes Sieve to
    create the list of all primes up to n for given n.
    """
    all_ints = [i for i in range(2, n+1)]
    primes = []
    for i in range(n-1):
        # if the integer at index i has not been ``crossed out'' already
        if all_ints[i] != 0:
            # then that integer must be prime
            prime = all_ints[i]
            primes.append(prime)
            j = i
            # ``cross out'' its multiples
            while j + prime < n - 1:
                all_ints[j + prime] = 0
                j += prime
    return primes


def linear_combo(a, b):
    """
    Helper method for inverse_mod(a, n)
    Returns a list [gcd(a, n), x, y]
    Where gcd(a, n) = ax + by
    """
    if a < 0 or b < 0:
        [g, am, bm] = linear_combo(abs(a), abs(b))
        if a == 0:
            asig = 0
        else:
            asig = int(a/abs(a))
        if b == 0:
            bsig = 0
        else:
            bsig = int(b/abs(b))
        return [g, am*asig, bm*bsig]

    if a == 0:
        return [b, 0, 1]
    if b % a == 0:
        return [a, 1, 0]
    if a % b == 0:
        return [b, 0, 1]

    # using the Extended Euclidean Algorithm
    first = [a, 1, 0]
    second = [b, 0, 1]
    # third = first % second
    third = [first[0] - second[0] * (first[0] // second[0]),
             first[1] - second[1] * (first[0] // second[0]),
             first[2] - second[2] * (first[0] // second[0])]
    while third[0] != 0:
        first = second
        second = third
        # third = first % second
        third = [first[0] - second[0]*(first[0]//second[0]),
                 first[1] - second[1]*(first[0]//second[0]),
                 first[2] - second[2]*(first[0]//second[0])]
    return second


def inverse_mod(a, n):
    """
    Write a code to find the inverse of a given number a mod n.
    Your code should give an error if there is no inverse.
    (If possible, use an efficient algorithm.)
    """
    lc = linear_combo(a, n)
    # gcd(n, m) = ax + ny
    # lc = [gcd(a, n), x, y]

    if lc[0] != 1:
        raise Exception(f"No inverse of {a} exists mod {n}.")
    return lc[1] % n


def phi(n):
    """
    Returns the number of integers less than abs(n)
    which are relatively prime to n.
    Euler phi function (or totient function).
    Checks every i from 1 to n.
    Almost certainly very inefficient.
    """
    p = 0
    for i in range(abs(n)):
        if gcd2(i, n) == 1:
            p += 1
    return p


def phi2(n):
    """
    Returns the number of integers less than abs(n)
    which are relatively prime to n.
    Euler phi function (or totient function).
    Finds prime factors of n and uses the generalized function.
    Almost certainly much more efficient than the first one.
    """
    if n == 1:
        return 1
    # a multiset of abs(n)'s prime factors
    factorization = prime_factors(n)
    # n = p1^k1 * p2^k2 * ...
    # with_powers = [p1, k1, p2, k2, ...]
    with_powers = []
    while factorization:
        p = factorization[0]
        count = factorization.count(p)
        with_powers += [p, count]
        # remove all occurrences of p
        factorization = list(filter(lambda a: a != p, factorization))

    ph = 1
    for i in range(0, len(with_powers), 2):
        p = with_powers[i]
        k = with_powers[i+1]
        ph *= pow(p, k-1)*(p-1)

    return ph


def prime_factors(n):
    """
    Returns a multiset of the prime factors of abs(n).
    """
    if n == 0:
        return []
    if n < 0:
        return prime_factors(abs(n))

    primes = sieve(int(pow(n, 0.5)))
    factors = []
    i = 0
    if primes:
        while n > 1:
            if divides2(primes[i], n):
                factors.append(primes[i])
                n = int(n/primes[i])
                i = 0
            else:
                i += 1
                # no more primes <= sqrt(n) divide n
                # but n > 1 still
                # there can be only 1 prime divisor > sqrt(n)
                if i >= len(primes):
                    return factors + [n]
        return factors
    return [n]


def order_mod(n, mod):
    """
    Returns the order of n modulo mod.
    The smallest k such that n^k % mod == 1
    """
    if mod < 2 or gcd2(n, mod) != 1:
        raise Exception(f"The order of {n} does not exist mod {mod}")
    n %= mod
    for k in range(1, mod):
        if int(pow(n, k, mod)) == 1:
            return k


def factorial_mod(n):
    """
    For each n, find (n-1)! (mod n)
    """
    if n == 1:
        return 0
    if n <= 0:
        raise Exception(f"{n-1}! does not exist.")
    val = 1
    for i in range(2, n):
        val = val*i % n
    return val


def congruence_solver(rems, mods):
    """
    Write a code to implement the Chinese Remainder Theorem.
    Your code should check if the conditions of the theorem apply.
    """
    # some input checks
    if len(rems) != len(mods):
        raise Exception("There must be as many remainders as mods.")
    num_eqs = len(rems)
    for mod in mods:
        if mod < 1:
            raise Exception("All mods must be at least 1")
    for i in range(len(mods)-1):
        for j in range(i+1, len(mods)):
            if gcd2(mods[i], mods[j]) != 1:
                raise Exception(f"All mods must be pairwise relatively prime "
                                f"({mods[i]} and {mods[j]} are not).")

    # reduce all remainders
    for i in range(num_eqs):
        rems[i] %= mods[i]

    # our final modulus
    n = 1
    for mod in mods:
        n *= mod

    # these steps follow the bullet points in worksheet 14
    # step 1
    mults = [n//mod for mod in mods]

    # step 2
    s = []
    for i in range(num_eqs):
        s.append(rems[i] * inverse_mod(mults[i], mods[i]))

    # step 3
    x = 0
    for i in range(num_eqs):
        x += mults[i]*s[i]
        x %= n

    return x

