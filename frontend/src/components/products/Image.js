import React, {useEffect, useState} from "react";
import imageRequests from "../../requests/image/imageRequests";

import "./css/image.css";

function Image(props) {

    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const response = await imageRequests.getImage(props.imageId);
            setData(response);
        };

        fetchData();
    });

    let image;
    let base64Img;
    if (data && data.image && data.image.data) {
        base64Img = `data:image/png;base64,${data.image.data}`;
    } else {
        base64Img = '';
    }

    image = base64Img ? <img className="image-component__img" src={base64Img} alt="Изображение" /> : <div className="image-component__empty">У продукта нет изображения</div>;

    return (
        <div className="image-component">{ image }</div>
    );
}

export default Image;
