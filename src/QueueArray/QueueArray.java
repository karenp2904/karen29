package QueueArray;

import java.util.Arrays;

public class QueueArray implements QueueInterface {
	
	private Object[] arrayQueue;
	private int top;
	private int end;
   	private int size;
   	private int maxSize;

   
	public QueueArray(int maxSize){
		this.arrayQueue = new Object[maxSize];
        this.top = 0;
        this.end = -1;
        this.size = 0;
        this.maxSize = maxSize;
        
    }
    
    public boolean insert(Object object) {
        boolean insertado = false;
        try {
        	
        	if(size()!=arrayQueue.length ) {
        		end=(end+1)%arrayQueue.length;
        		arrayQueue[end]=object;
        		size++;
        		insertado=true;
        	}else {
        		System.out.println("La cola ya esta llena");
        		insertado = false;
        	}
        } catch (Exception e) {
            System.out.println(e);  
        }
        return insertado;
    }
    
    @Override
    public void clear() {
        try {
            if (!isEmpty()){
            	arrayQueue=null;
            	size=0;
            	end = -1;
            	top = 0;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public boolean isEmpty() {
      if(size != -1){
          return false;
      }else {
          return true;
      }
    }
    
    @Override
    public Object extract() {
            if(!isEmpty()){
            	 Object pop = arrayQueue[top];
                 if (top == maxSize -1 ){
                     arrayQueue[top] = null;
                     top = 0;
                     size--;
                 }
                 else{
                	 arrayQueue[top++] = null;
                	 size--;
                 }
                 return pop;
            }else {
            	return null;
            }

    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    
    @Override
    public boolean search(Object object) {
    	boolean encontrado=false;
        try {
            for (int i = 0; i < size; i++) {
                if (arrayQueue[i] == object) {
                    encontrado= true;
                }
            }
            return encontrado;
        } catch (Exception e) {
        }finally {
        	return encontrado;
        }
    }
    
    @Override
    public void sort() {
        try {
            if (!isEmpty()&& size()>1){
                Object temporal;
                for (int i = 0; i < arrayQueue.length-1; i++) {
					for (int j = 0; j < arrayQueue.length-1; j++) {
						if ((arrayQueue[i].toString().compareTo(arrayQueue[j+1].toString())>0)) {
							temporal=arrayQueue[i];
							arrayQueue[i]=arrayQueue[j+1];
							arrayQueue[j+1]=temporal;
						}
					}
				}
            }
        }catch (Exception e){
            System.out.println("sort " + e);
        }
    }
    
    @Override
    public void reverse() {

        try {
            int j = 0;
            Object [] temp = new Object[size];
            for (int i = size -1 ; i >= 0; i--) {
                temp[j] =arrayQueue[i];
                j++;
            }
            for (int i = 0; i < size; i++) {
            	arrayQueue[i]= temp[i];
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

    public String toString() {
        if(!isEmpty()){
            StringBuilder print = new StringBuilder("[");
            for (int i = top; i <=end; i++)
            {
            	print.append(arrayQueue.toString());
                if (i < end) {
                	print.append(", ");
                }
            }
            print.append("]");
            return print.toString();
        }else {
        	return "La cola se encuentra vacia";
        }
    }
   

}
