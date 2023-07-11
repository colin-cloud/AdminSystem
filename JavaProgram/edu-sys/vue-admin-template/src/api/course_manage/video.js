import request from '@/utils/request'

export default  {
  removeVideoById(id) {
    return request({
      url: `/edu-vod/vod/removeByVideoId/${id}`,
      method: 'delete'
    });
  }
}
