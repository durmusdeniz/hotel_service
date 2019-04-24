class Room  extends React.Component{

    constructor(props){
        super(props);
        this.state ={
            id : props.id,
            type : props.type,
            occupied:props.occupied
        }
    }


    render(){
        return(
            <button className="btn btn-success">StubRoom</button>
        );
    }
}