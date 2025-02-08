
 public int binomialExponent(int b , int e){
    int res = 1;
    while(e > 0){
        if((e & 1) != 0) res = (res * b) % mod;
        b = (b * b) % mod;
        e >>= 1;
    }
    return res;
 }