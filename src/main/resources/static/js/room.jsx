class Room  extends React.Component{

    constructor(props){
        super(props);
        this.state ={
            id : props.id,
            roomCode : props.roomCode,
            occupied:props.occupied,
            capacity: props.capacity
        }
    }


    render(){
        return(
            <button id={this.state.id} onClick={this.props.book} className={this.state.occupied == true ? "btn btn-danger":"btn btn-success"}>{this.state.roomCode}</button>
        );
    }
}