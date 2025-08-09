#include<iostream>
using namespace std;
#define V 4 

void init(int arr[V][V]){
    int r,c;
    for(r=0; r<V; r++){
        for(c=0; c<V; c++){
            arr[r][c] = 0;
    }
}
}

void insertEdge(int arr[V][V],int i,int j){
    arr[i][j] = 1;
    arr[j][i]=1;

}

void printAdjacencyMatrix(int arr[V][V]){
    int r,c;
    for(r=0; r<V; r++){
        cout<<r<<": ";
        for(c=0; c<V; c++){
            cout<<arr[r][c]<<" ";
            }
            cout<<endl;
}
}
int main(){
    int arr[V][V];
    init(arr);
    insertEdge(arr,0,1);
    insertEdge(arr,0,2);
    insertEdge(arr,1,2);
    insertEdge(arr,2,0);
    insertEdge(arr,2,3);
    printAdjacencyMatrix(arr);
}


