
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ��С������(����ķ�㷨(Prim�㷨))
 * @author zhangming
 * @date 2016/04/20
 */
public class MinTreePrimer {
    private static List<Vertex> visitedVertexs,leftedVertexs; //�ֱ�Ϊ��ӵ�����U�еĽڵ㼯��ʣ��ļ���V�еĽڵ㼯
    private static List<Edge> searchEdges;
    
    //��ʼ��ͼ����Ϣ
    public static void initGraph(Graph g){
        visitedVertexs = new ArrayList<Vertex>();
        leftedVertexs = new ArrayList<Vertex>();
        searchEdges = new ArrayList<Edge>();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("���붥����: ");
        int vertexNumber = sc.nextInt();
        System.out.print("���������: ");
        int edgeNumber = sc.nextInt();
        String[] allVertex = new String[vertexNumber];
        String[] allEdge = new String[edgeNumber];
        
        System.out.println("=================================");
        System.out.println("�������������:");
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<vertexNumber;i++){
            System.out.print("����"+(i+1)+":");
            allVertex[i] = scanner.nextLine();
        }
        System.out.println("=================================");
        for(int i=0;i<edgeNumber;i++){
            System.out.print("�����(Vi,Vj)�еĶ������ƺ�ȨֵW(��:A B 7): ");
            allEdge[i] = scanner.nextLine();
        }
        
        g.vertex = new Vertex[allVertex.length];
        g.edge = new Edge[allEdge.length];
        g.minWeight = 0;
        
        for(int i=0;i<allVertex.length;i++){
            g.vertex[i] = new Vertex();
            g.vertex[i].vName = allVertex[i];
            leftedVertexs.add(g.vertex[i]); //��ʼ��ʣ��㼯��
        }
        
        for(int i=0;i<allEdge.length;i++){
            g.edge[i] = new Edge();
            g.edge[i].startVertex = new Vertex();
            g.edge[i].endVertex = new Vertex();
            
            String edgeInfo[] = allEdge[i].split(" ");
            g.edge[i].startVertex.vName = edgeInfo[0];
            g.edge[i].endVertex.vName = edgeInfo[1];
            g.edge[i].weight = Integer.parseInt(edgeInfo[2]);
        }
    }
    
    public static void onChangeVertex(Vertex vertex){
        visitedVertexs.add(vertex); //��ӳ�ʼ�ڵ�,��ΪĬ�ϵĿ�ʼ�ڵ�
        leftedVertexs.remove(vertex);
    }
    
    public static Vertex findOneVertex(Graph g){
        int minValue = Integer.MAX_VALUE;
        Vertex findVertex = new Vertex();
        Edge findEdge = new Edge();
        
        for(int i=0;i<visitedVertexs.size();i++){
            for(int j=0;j<leftedVertexs.size();j++){
                Vertex v1 = visitedVertexs.get(i);
                Vertex v2 = leftedVertexs.get(j); //��ȡ�������������
                
                for(int k=0;k<g.edge.length;k++){
                    String startName = g.edge[k].startVertex.vName;
                    String endName = g.edge[k].endVertex.vName;
                    
                    if((v1.vName.equals(startName) && v2.vName.equals(endName))
                    		||(v1.vName.equals(endName) && v2.vName.equals(startName))){
                        if(g.edge[k].weight < minValue){
                            findEdge = g.edge[k];
                            minValue = g.edge[k].weight;
                            if(leftedVertexs.contains(v1)){ //����ö����equals�����Ƚ϶���,����дequals����
                                findVertex = v1;
                            }else if(leftedVertexs.contains(v2)){
                                findVertex = v2;
                            }
                        }
                    }
                }
            }
        }
        g.minWeight+= minValue;
        searchEdges.add(findEdge);
        
        return findVertex;
    }
    
    public static void prim(Graph g){
        while(leftedVertexs.size()>0){ //ֱ��ʣ��ڵ㼯Ϊ��ʱ����ѭ��
            Vertex findVertex = findOneVertex(g);
            onChangeVertex(findVertex);
        }
        System.out.print("\n���·�������ı�: ");
        for(int i=0;i<searchEdges.size();i++){
            System.out.print("("+searchEdges.get(i).startVertex.vName+","+searchEdges.get(i).endVertex.vName+")"+" ");
        }
        System.out.println("\n���·������: "+g.minWeight);
    }
    
    public static void main(String[] args) {
        Graph g = new Graph();
        initGraph(g);
        onChangeVertex(g.vertex[0]);
        prim(g);
    }
}

/**
 * ������Vertex
 */
class Vertex{
    String vName; //���������
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vertex){
            Vertex vertex = (Vertex)obj;
            return this.vName.equals(vertex.vName);
        }
        return super.equals(obj);
    }
}

/**
 * ����Edge
 */
class Edge{
    Vertex startVertex;
    Vertex endVertex;
    int weight;
}

/**
 * ͼ�Ĵ洢�ṹ
 */
class Graph{
    Vertex[] vertex; //���㼯
    Edge[] edge; //�߼�
    int minWeight; //���·��
}