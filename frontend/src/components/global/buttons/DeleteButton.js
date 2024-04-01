import deleteImg from "../../../icons/delete.png";
import "../css/global-components.css";

function DeleteButton(props) {

    return (
        <button className="delete-button" onClick={props.deleteFunction}>
            <img className="delete-button__icon" src={deleteImg} alt="" />
        </button>
    );
}

export default DeleteButton;