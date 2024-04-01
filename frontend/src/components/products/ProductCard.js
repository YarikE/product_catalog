import Image from "./Image";
import DeleteButton from "../global/buttons/DeleteButton";
import EditButton from "../global/buttons/EditButton";
import Switcher from "../global/buttons/Switcher";

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
            <div className="product-card__switcher">
                <Switcher initialValue={ props.status } productId={ props.id } />
            </div>
        </div>
    );
}

// name
//
// description
//
// image_id
//
// price
//
// status
//
// category.name
// category.description
//
// add_date

export default ProductCard;
