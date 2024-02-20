class GFG{ 

    static int powerOptimised(int a, int n) 
    {
        int ans = 1; 
        while (n > 0) 
        { 
            int last_bit = (n & 1); 
            if (last_bit > 0)
            { 
                ans = ans * a; 
            } 
            a = a * a; 
            n = n >> 1; 
        } 
        return ans; 
    } 
    public static void main(String[] args) 
    { 
        int a = 3, n = 5; 
    
        System.out.print(powerOptimised(a, n)); 
    }
    }
    