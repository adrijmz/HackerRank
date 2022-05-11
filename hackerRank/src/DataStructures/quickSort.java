package DataStructures;

public class quickSort{
    
    public static void quickSortRec(int vec[], int inicio, int fin){
        if(inicio>=fin) return;
        int pivote=vec[inicio];
        int elemIzq=inicio+1;
        int elemDer=fin;
        while(elemIzq<=elemDer){
                while(elemIzq<=fin && vec[elemIzq]<pivote){
                        elemIzq++;
                }
                while(elemDer>inicio && vec[elemDer]>=pivote){
                        elemDer--;
                }
                if(elemIzq<elemDer){
                        int temp=vec[elemIzq];
                        vec[elemIzq]=vec[elemDer];
                        vec[elemDer]=temp;
                }
        }
        
        if(elemDer>inicio){
                int temp=vec[inicio];
                vec[inicio]=vec[elemDer];
                vec[elemDer]=temp;
        }
        quickSortRec(vec, inicio, elemDer-1);
        quickSortRec(vec, elemDer+1, fin);
}
    public static void main (String args[]){
        int[] myArr = {6,4,7,4,9};
        quickSortRec(myArr, 0, myArr.length-1);
        for(int i=0;i<myArr.length;i++){
            System.out.print(myArr[i]);
        }
    }
}