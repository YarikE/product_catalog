import "./css/category.css";

import Switcher from "../../components/global/buttons/Switcher";
import EditButton from "../../components/global/buttons/EditButton";
import DeleteButton from "../../components/global/buttons/DeleteButton";
import DropDown from "../../components/products/DropDown";

function CategoryView() {
    return (
        <div className="category-view">
            <h1 className="category-view__header">Список категорий</h1>
            <div className="category-view__content">
                <DeleteButton />
                <EditButton />
                <Switcher />
                <DropDown />
            </div>
        </div>
    );
}

export default CategoryView;