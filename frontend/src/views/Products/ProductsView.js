import "./product.css"
import productRequests from "../../requests/product/productRequests"

function ProductsView() {

    async function getProducts() {
        const result = await productRequests.getAllProducts();
        console.log(result);
    }

    return (
        <div className="product-view">
            <h1>Список продуктов</h1>
            <div className="product-view__content">
                <button onClick={getProducts}>TEST</button>
            </div>
        </div>
    );
}

export default ProductsView;