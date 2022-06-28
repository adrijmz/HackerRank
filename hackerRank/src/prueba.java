public class prueba{
    
    public static List<Integer> quicksort(List<Integer> arr){
        if(arr.size()<2) return arr;
        else{
            int pivot = arr.get(0);
            List<Integer> less = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();
            for(int i=0; i<arr.size(); i++){
                if(arr.get(i)<=pivot) less.add(arr.get(i));
                else greater.add(arr.get(i));
            }
            return quicksort(less) + [pivot] + quicksort(greater);
            
        }
    }

    public static void main(String args[]){
        System.out.println('hola');
    }
}