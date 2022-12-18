import java.util.LinkedList;

public class HashTables {
    LinkedList [] array;



    public HashTables(){
        array=new LinkedList[100];
    }


    public void put(int key ,String value){
       int location= hashFunction(key);
       if(array[location]==null){
           LinkedList linkedList=new LinkedList();
           array[location]=linkedList;
           Node node = new Node(key,value);
           linkedList.add(node);
           return;
       }
      LinkedList linkedList=array[location];
       for(Object object: linkedList){
          Node node =(Node) object;
          if(node.key==key){
              node.value=value;
              return;
          }
       }

       Node node=new Node(key, value);
       linkedList.add(node);
    }




    public int hashFunction(int key){
        return key%100;
    }


    public String get(int key){
        LinkedList<Node> linkedList=array[hashFunction(key)];
        for(Node node:linkedList){
            if(node.key==key)
                return node.value;
        }
        return "notfound";
    }

   //this is the remove method for hashtables
    public Node remove(int key){
        int index=hashFunction(key);
        for(Object object:array[index]){
            Node node=(Node) object;
            if(node.key==key){
                array[index].remove(node);
                return node;
            }
        }
        throw new IllegalStateException("Not found");
    }



}
