import EditButton from "../global/buttons/EditButton";
import DeleteButton from "../global/buttons/DeleteButton";

import "./css/caregory-card.css";
function CategoryCard({categoryName, categoryDescription}) {
    return (
        <div className="category-card">
            <div className="category-card__content">
                <div className="category-card__name">Название: {categoryName}</div>
                <div className="category-card__description">Описание: {categoryDescription}</div>
            </div>

            <div className="category-card__buttons">
                <DeleteButton deleteFunction={() => {}}/>
                <EditButton/>
            </div>
        </div>
    );
}

export default CategoryCard;