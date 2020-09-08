package Recursion;

/**
 * Mazepath
 */
public class Mazepath {

    public static int mazePath(int sr,int sc, int er ,int ec){
       if(sr==er && sc==ec){
           return 1;
       }   
       
        int count=0 ;
        if(sr+1<=er){
            count = count+mazePath(sr+1, sc, er, ec);
        }
        if(sc+1<=ec){
            count = count+mazePath(sr, sc+1, er, ec);
        }
        return count;
    }
    
    
    
    public static int mazePath(int sr,int sc, int er ,int ec,String path){
        if(sr==er && sc==ec){
            System.out.println(path);
            return 1;

        }   
        
         int count=0 ;
         if(sr+1<=er){
             count = count+mazePath(sr+1, sc, er, ec,path + "v");
         }
         if(sc+1<=ec){
             count = count+mazePath(sr, sc+1, er, ec,path+"h");
         }
         return count;
     }

     public static int mazePathDiagonal(int sr,int sc, int er ,int ec,String path){
        if(sr==er && sc==ec){
            System.out.println(path);
            return 1;
        }   
        
         int count=0 ;
         if(sr+1<=er){
             count = count+ mazePathDiagonal(sr + 1, sc, er, ec, path + "v");
         }
         if(sc+1<=ec){
             count = count+mazePathDiagonal(sr, sc+1, er, ec,path + "h");
         }
         if(sr+1<=er && sc+1<=ec){
            count = count+mazePathDiagonal(sr+1, sc+1, er, ec,path+"d");
        }
         return count;
     }
 


     public static int mazePathMultiple(int sr,int sc, int er ,int ec,String path){
        if(sr==er && sc==ec){
            System.out.println(path);
            return 1;
        }  
        int count=0 ;


                            // WRONG CODE 
        /*
         
         for(int i = 1 ; i<=er ;i++){
             for(int j = 1 ; j<=ec ; j++){
                if(sr+i<=er){
                    count = count+ mazePathMultiple(sr + i, sc, er, ec, path + "v");
                }
                if(sc+j<=ec){
                    count = count+mazePathMultiple(sr, sc+j, er, ec,path + "h");
                }
                if(sr+i<=er && sc+j<=ec){
                   count = count+mazePathMultiple(sr+i, sc+j, er, ec,path+"d");
               }
             }
         }
         */

        //horizontal calls 
        for(int  i = 1;i<=ec-sc;i++){
           count = count + mazePathMultiple(sr, sc+i, er, ec, path + "h" + i);
        }         
         //vertical calls 
         for(int  i = 1;i<=er-sr;i++){
            count = count + mazePathMultiple(sr+i, sc, er, ec, path + "v" + i);
        }

        //diagonal calls
        for(int i = 1;i<=er-sr && i<=ec-sc; i++){
            count = count + mazePathMultiple(sr+i, sc+i, er, ec, path + "d" + i);
        }

         return count;
     }
 

    public static void main(String[] args) {
        System.out.println(mazePathMultiple(0,0,3,3,""));
    }
}
