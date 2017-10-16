/*
 * Copyright (c) 2017, Mikl&oacute;s Cs&#369;r&ouml;s
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package unionfind;

/**
 *
 * @author Mikl&oacute;s Cs&#369;r&ouml;s
 */
public class UnionFind 
{
    private int[] parent;
    private int[] size;
    
    public UnionFind(int n)
    {
        this.parent = new int[n];
        this.size = new int[n];
        for (int i=0; i<n; i++)
        {
            parent[i] = i;
            size[i]=1;
        }
    }
    
    /**
     * Union avec taille du résultat retourné.
     * 
     * @param x
     * @param y
     * @return taille après fusion
     */
    public int union(int x, int y)
    {
        int p = find(x);
        int q = find(y);
        if (p!=q)
        {
            int s = size[p]+size[q];
            /*
            if (size[p]<=size[q]) 
            ...


            return s;
                    */
        }
        return 0;
    }
    
    public int find(int x)
    {
        return -1;
        /* ... */
    }
}
