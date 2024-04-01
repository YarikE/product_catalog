import axios from "axios";

const basePath = "http://localhost:8080";

const requests = {

    /**
     * Получить изображение
     *
     * @param id Id изображения
     */
    getImage: (id) => {
        if (id === null) {
            return null
        }
        return axios.get(basePath + `/image/${id}`)
            .then(response => {
                return response.data;
            })
            .catch(err => {
                console.log(err);
            })
    }

}

export default requests;