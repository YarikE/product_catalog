import Image from "./Image";
import Switcher from "../global/buttons/Switcher";
import EditButton from "../global/buttons/EditButton";
import DeleteButton from "../global/buttons/DeleteButton";

import productRequests from "../../requests/product/productRequests";

import "./css/product-card.css"

function ProductCard (props) {

    return (
        <div className="product-card">

            <div className="product-card__buttons">
                <DeleteButton deleteFunction={ () => productRequests.deleteProduct(props.id) } />
                <EditButton />
            </div>

            <Image imageId={ props.imageId } />

            <div className="product-card__name">Название: { props.name }</div>
            <div className="product-card__description">Описание: { props.description }</div>
            <div className="product-card__price">Цена: { props.price } ₽</div>
            <div className="product-card__category">Категория: { props.categoryName }</div>
            <div className="product-card__switcher">
                <Switcher initialValue={ props.status } productId={ props.id } />
            </div>
        </div>
    );
}

export default ProductCard;
