import "../css/global-components.css";
import editIcon from "../../../icons/edit.png";

function EditButton(props) {
    return (
        <button className="edit-button">
            <img className="edit-button__icon" src={editIcon} alt=""/>
        </button>
    );
}

export default EditButton;
