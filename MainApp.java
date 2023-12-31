import java.io.FileReader;
import java.util.Scanner;

import src.Graph;

/**
 * MainApp
 */
public class MainApp {
    static Graph graph = new Graph();

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){
            GenerateData(new FileReader("graph.txt"));
            DisplayData();
        }catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
    public static void DisplayData() throws StringIndexOutOfBoundsException{
        //graph.printGraph();
        graph.showNodes();
        System.out.println("BreadthFirst");
        graph.breadthFirstSearch();
        System.out.println();
        System.out.println("DepthFirst");
        graph.depthFirstSearch();
    }
    public static void GenerateData(FileReader fr){
        try(Scanner sc = new Scanner(fr)){
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(" ");
                
                if(data.length > 1){
                    graph.addEdge(data[0], data[1]);
                }else{
                    graph.addNode(data[0]);
                }
            }
            //System.out.println("Data has been loaded to the list");
        } catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
}